const mongoose = require('mongoose'),
	Schema = mongoose.Schema,
	Store = require('./store'),
	City = require('./city'),
	bcrypt = require('bcrypt-nodejs'),
	config = require('../../config').config(),
	fs = require('fs'),
	{ concat } = require('lodash');

const StoreCommunitySchema = new Schema({
	name: { type: String, required: 'Community name is required.', unique: false, maxlength: [70, 'Community name should have at most 70 characters.'] },
	description: { type: String, required: false, select: false, minlength: [3, 'Description should have at least 3 characters.'], maxlength: [500, 'Description should have at most 500 characters.'] },
	address: { type: String, required: false, select: false, minlength: [10, 'Address should have at least 10 characters.'], maxlength: [500, 'Address should have at most 500 characters.'] },
	stores: [{ type: Schema.Types.ObjectId, ref: 'Store' }],
	city: { type: Schema.Types.ObjectId, ref: 'City' }
});

StoreCommunitySchema.methods.addStore = function (store) {
	concat(this.stores, store);
}

module.exports = mongoose.model('StoreCommunity', StoreCommunitySchema);
