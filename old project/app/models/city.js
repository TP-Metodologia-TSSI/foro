const mongoose = require('mongoose'),
    Schema = mongoose.Schema,
    StoreCommunity = require('./storeCommunity'),
    bcrypt = require('bcrypt-nodejs'),
    config = require('../../config').config(),
    fs = require('fs'),
    { concat } = require('lodash');

const CitySchema = new Schema({
    name: { type: String, required: 'City name is required.', unique: false, maxlength: [70, 'Community name should have at most 70 characters.'] },
    description: { type: String, required: false, select: false, minlength: [3, 'Description should have at least 3 characters.'], maxlength: [500, 'Description should have at most 500 characters.'] },
    storeCommunities: [{ type: Schema.Types.ObjectId, ref: 'StoreCommunity' }]
});

CitySchema.methods.addStoreCommunity = function (community) {
    concat(this.storeCommunities, community);
}

module.exports = mongoose.model('City', CitySchema);
