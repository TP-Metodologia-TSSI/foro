const mongoose = require('mongoose'),
    Schema = mongoose.Schema,
    bcrypt = require('bcrypt-nodejs'),
    config = require('../../config').config(),
    fs = require('fs');

const HobbySchema = new Schema({
    name: { type: String, required: 'Hobby name is required.', unique: false, maxlength: [70, 'Hobby name should have at most 70 characters.'] },
    description: { type: String, required: false, select: false, minlength: [3, 'Description should have at least 3 characters.'], maxlength: [500, 'Description should have at most 500 characters.'] }
});

module.exports = mongoose.model('Hobby', HobbySchema);
