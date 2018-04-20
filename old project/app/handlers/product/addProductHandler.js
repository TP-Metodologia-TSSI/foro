const jwt = require('jsonwebtoken'),
	config = require('../../../config').config(),
	Product = require('../../models/product'),
	Subcategory = require('../../models/subcategory'),
	Brand = require('../../models/brand');

async function addProduct(req, res) {
	const product = new Product();
	const subcategory = await Subcategory.findById(req.body.subcategory).exec(function (err, subcategory) {
		if (err) return handleError(err);
	});
	const brand = await Brand.findById(req.body.brand).exec(function (err, subcategory) {
		if (err) return handleError(err);
	});

	product.picture = { "url": req.body.pictureUrl, "horizontalSize": req.body.pictureHorizontalSize, "verticalSize": req.body.pictureVerticalSize };
	product.name = req.body.name;
	product.description = req.body.description;
	product.subcategory = subcategory;
	product.brand = brand;

	product.save(function (err) {
		if (err) {
			console.log(err);
		};
	});

	await Brand.findByIdAndUpdate(req.body.brand, { '$push': { 'products': product } }, { new: true });
	await Subcategory.findByIdAndUpdate(req.body.subcategory, { '$push': { 'products': product } }, { new: true });

	res.json({
		message: 'Product added.'
	});
}

exports.addProduct = addProduct;
