const jwt = require('jsonwebtoken'),
	config = require('../../../config').config(),
	Store = require('../../models/store'),
	Product = require('../../models/product'),
	{ concat } = require('lodash');

function changeStoreProductPrice(req, res) {
	const store = Store.findById(req.body.store).exec(function (err, store) {
		if (err) return handleError(err);
	});
	const product = Product.findById(req.body.product).exec(function (err, product) {
		if (err) return handleError(err);
	});
	const price = req.body.price;

	store.changeProductPrice(product, price);
}

exports.changeStoreProductPrice = changeStoreProductPrice;
