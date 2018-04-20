const jwt = require('jsonwebtoken'),
	config = require('../../../config').config(),
	Store = require('../../models/store'),
	Product = require('../../models/product'),
	{ concat } = require('lodash');

async function addStoreProduct(req, res) {
	const store = await Store.findById(req.body.store).exec(function (err, store) {
		if (err) return handleError(err);
	});
	const product = await Product.findById(req.body.product).exec(function (err, product) {
		if (err) return handleError(err);
	});
	const price = req.body.price;

	store.addProduct(product, price);
}

exports.addStoreProduct = addStoreProduct;
