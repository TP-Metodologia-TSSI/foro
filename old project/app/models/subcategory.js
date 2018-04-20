const mongoose = require('mongoose'),
	Schema = mongoose.Schema,
	Category = require('./category'),
	Product = require('./product'),
	bcrypt = require('bcrypt-nodejs'),
	config = require('../../config').config(),
	fs = require('fs'),
	{ concat } = require('lodash');

const SubcategorySchema = new Schema({
	name: { type: String, required: 'Subcategory name is required.', unique: false, maxlength: [70, 'Subcategory name should have at most 70 characters.'] },
	categories: [{ type: Schema.Types.ObjectId, ref: 'Category' }],
	products: [{ type: Schema.Types.ObjectId, ref: 'Product' }]
});

module.exports = mongoose.model('Subcategory', SubcategorySchema);
