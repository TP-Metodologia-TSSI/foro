const mongoose = require('mongoose'),
	Schema = mongoose.Schema,
	Product = require('./product'),
	bcrypt = require('bcrypt-nodejs'),
	config = require('../../config').config(),
	fs = require('fs'),
	{ drop, concat } = require('lodash');

const StoreSchema = new Schema({
	name: { type: String, required: 'Store name is required.', unique: false, maxlength: [70, 'Store name should have at most 70 characters.'] },
	community: { type: Schema.Types.ObjectId, ref: 'StoreCommunity', required: 'A store must belong to a store community.' },
	products: [{
		price: { type: Number, required: 'Product must have an in-store price.' },
		available: { type: Boolean, default: true },
		product: { type: Schema.Types.ObjectId, ref: 'Product' }
	}],
	inBusiness: { type: Boolean, default: true },
	directions: { type: String, required: false, unique: false, maxlength: [70, 'Directions should have at most 70 characters.'] }
});

StoreSchema.methods.addProduct = function (product, price) {
	concat(this.products, { price: price, available: true, product: product });
}

StoreSchema.methods.removeProduct = function (product) {
	this.products.findOneAndUpdate({ product: product, available: true }, { available: false });
}

StoreSchema.methods.changeProductPrice = function (product, newPrice) {
	this.products.findOneAndUpdate({ product: product }, { price: newPrice });
}

module.exports = mongoose.model('Store', StoreSchema);
