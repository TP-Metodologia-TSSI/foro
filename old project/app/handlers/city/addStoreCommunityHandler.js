const jwt = require('jsonwebtoken'),
  config = require('../../../config').config(),
  City = require('../../models/city'),
  StoreCommunity = require('../../models/storeCommunity'),
  { concat } = require('lodash');

async function addStoreCommunity(req, res) {
  const community = new StoreCommunity();
  community.name = req.body.name;
  community.description = req.body.description;
  community.address = req.body.address;
  community.stores = [];

  community.city = await City.findById(req.body.city);

  community.save(function (err) {
     if (err) {
       console.log(err);
       return err;
     };
  });

  await City.findByIdAndUpdate(req.body.city, { '$push': { 'storeCommunities': community } }, { new : true });

  res.json({
    message: 'Store community added.'
  });
}

exports.addStoreCommunity = addStoreCommunity;
