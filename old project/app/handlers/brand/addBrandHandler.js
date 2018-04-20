const jwt = require('jsonwebtoken'),
	config = require('../../../config').config(),
	Brand = require('../../models/brand');

function addBrand(req, res) {
	const brand = new Brand();
	brand.name = req.body.name;
	brand.description = req.body.description;
	brand.products = [];

	brand.save(function (err) {
		if (err) {
			console.log(err);
			return err;
		};
	});

	res.json({
		message: 'Brand added.'
	});
}

exports.addBrand = addBrand;
