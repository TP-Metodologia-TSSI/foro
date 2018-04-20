const jwt = require('jsonwebtoken'),
	config = require('../../../config').config(),
	Brand = require('../../models/brand');

async function getBrands(req, res) {
	const brands = await Brand.find();

	console.log(brands);

	res.json(brands);
}

exports.getBrands = getBrands;
