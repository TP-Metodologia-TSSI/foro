const mongoose = require('mongoose'),
  Schema = mongoose.Schema,
  Brand = require('../models/brand'),
  bcrypt = require('bcrypt-nodejs'),
  config = require('../../config').config(),
  fs = require('fs');

const ProductSchema = new Schema({
    name: { type: String, required: 'Product name is required.', unique: false, maxlength: [200, 'Product name should have at most 200 characters.'] },
    description: { type: String, required: false, select: false, minlength: [3, 'Description should have at least 3 characters.'], maxlength: [500, 'Description should have at most 500 characters.'] },
    brand: { type: Schema.Types.ObjectId, ref: 'Brand' },
    subcategory: { type: Schema.Types.ObjectId, ref: 'Subcategory' },
    picture: {
        url: { type: String, required: false },
        horizontalSize: { type: Number, required: false },
        verticalSize: { type: Number, required: false },
        required: false
    },
    confirmationPending: { type: Boolean, default: true }
});

ProductSchema.methods.setPictureUrl = function (url) {
    this.set('pictureUrl', url);
}

ProductSchema.methods.confirm = function() {
    this.confirmationPending = false;
}

module.exports = mongoose.model('Product', ProductSchema);
