const mongoose = require('mongoose'),
    Schema = mongoose.Schema,
    Subcategory = require('./subcategory'),
    bcrypt = require('bcrypt-nodejs'),
    config = require('../../config').config(),
    fs = require('fs'),
    { concat } = require('lodash');

const CategorySchema = new Schema({
    name: { type: String, required: 'Category name is required.', unique: true, maxlength: [70, 'Category name should have at most 70 characters.'] },
    subcategories: [{ type: Schema.Types.ObjectId, ref: 'Subcategory' }]
});

CategorySchema.methods.addSubcategory = function (product) {
    concat(this.products, product);
}

module.exports = mongoose.model('Category', CategorySchema);
