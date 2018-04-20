const jwt = require('jsonwebtoken'),
	config = require('../../../config').config(),
	Store = require('../../models/store'),
	StoreCommunity = require('../../models/storeCommunity'),
	{ concat } = require('lodash');

async function addStore(req, res) {
	const storeCommunity = await StoreCommunity.findById(req.body.storeCommunity).exec(function (err, storeCommunity) {
		if (err) return handleError(err);
	});
	const store = new Store();
	store.name = req.body.name;
	store.community = storeCommunity;
	store.directions = req.body.directions;
	store.products = [];

	store.save(function (err) {
		if (err) {
			console.log(err);
		};
	});

	await StoreCommunity.findByIdAndUpdate(storeCommunity._id, { '$push': { 'stores': store } }, { new: true });

	res.json({
		message: 'Store added.'
	});
}

exports.addStore = addStore;
