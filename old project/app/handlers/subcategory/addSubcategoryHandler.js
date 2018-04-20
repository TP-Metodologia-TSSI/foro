const jwt = require('jsonwebtoken'),
	config = require('../../../config').config(),
	Category = require('../../models/category'),
	Subcategory = require('../../models/subcategory'),
	{ concat } = require('lodash');

async function addSubcategory(req, res) {
	const subcategory = new Subcategory();
	subcategory.name = req.body.name;
	subcategory.products = [];
	subcategory.categories = [];

	var category;

	// await Promise.all(req.body.categories).then(categoryIndex => addCategory(subcategory, categoryIndex)); Only works for first value in array. Why?

	subcategory.save(function (err) {
		if (err) {
			console.log(err);
			return err;
		};
	});

	await req.body.categories.forEach(async function (categoryIndex) {
		category = await Category.findByIdAndUpdate(categoryIndex, { '$push': { 'subcategories': subcategory } }, { new: true });
		await Subcategory.findByIdAndUpdate(subcategory._id, { '$push': { 'categories': category } }, { new: true });
	});

	res.json({
		message: 'Subcategory added.'
	});
}

async function addCategory(subcategory, categoryIndex) {
	const category = await Category.findByIdAndUpdate(categoryIndex, { '$push': { 'subcategories': subcategory } }, { new: true });
	console.log("Name");
	console.log(category.name);
	subcategory.categories.push(category);
}


exports.addSubcategory = addSubcategory;
