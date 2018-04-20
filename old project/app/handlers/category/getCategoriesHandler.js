const jwt = require('jsonwebtoken'),
	config = require('../../../config').config(),
	Category = require('../../models/category');

async function getCategories(req, res) {
	const categories = await Category.find();

	categories.sort(function (a, b) {
		return a.name.localeCompare(b.name);
	});

	res.json(categories);
}

exports.getCategories = getCategories;
