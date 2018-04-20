const jwt = require('jsonwebtoken'),
	config = require('../../../config').config(),
	Subcategory = require('../../models/subcategory');

async function getSubcategories(req, res) {
	const subcategories = await Subcategory.find();

	res.json(subcategories);
}

exports.getSubcategories = getSubcategories;
