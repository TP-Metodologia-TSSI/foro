const mongoose = require('mongoose'),
	Schema = mongoose.Schema,
	Product = require('./product'),
	bcrypt = require('bcrypt-nodejs'),
	config = require('../../config').config(),
	fs = require('fs'),
	{ concat } = require('lodash');

const BrandSchema = new Schema({
	name: { type: String, required: 'Brand name is required.', unique: false, maxlength: [70, 'Brand name should have at most 70 characters.'] },
	description: { type: String, required: false, select: false, minlength: [3, 'Description should have at least 3 characters.'], maxlength: [500, 'Description should have at most 500 characters.'] },
	products: [{ type: Schema.Types.ObjectId, ref: 'Product' }]
});

BrandSchema.methods.addProduct = function (product) {
  	concat(this.products, product);
}

module.exports = mongoose.model('Brand', BrandSchema);
