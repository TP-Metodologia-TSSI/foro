const jwt = require('jsonwebtoken'),
	config = require('../../../config').config(),
	Category = require('../../models/category');

async function addCategory(req, res) {
	const category = new Category();
	category.name = req.body.name;
	category.subcategories = [];

	const existing = await Category.find({ 'name': category.name });

	if (existing.length != 0) {
		console.log(existing);
		res.json({
			message: 'Category already exists.'
		});
	}
	else {
		category.save(function (err) {
			if (err) {
				console.log(err);
				return err;
			};
		});
	}

	res.json({
		message: 'Category added.'
	});
}

exports.addCategory = addCategory;
