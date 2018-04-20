const mongoose = require('mongoose'),
    Schema = mongoose.Schema,
    Product = require('./product'),
    StoreCommunity = require('./storeCommunity'),
    Hobby = require('./hobby'),
    Profession = require('./profession'),
    Store = require('./store'),
    bcrypt = require('bcrypt-nodejs'),
    config = require('../../config').config(),
    fs = require('fs');

const ConsultationSchema = new Schema({
    profession: { type: Schema.Types.ObjectId, ref: 'Profession', required: false, select: false },
    age: { type: Number, required: false, select: false },
    priceRangeMin: { type: Number, required: true },
    priceRangeMax: { type: Number, required: true },
    recommendations: [{ type: Schema.Types.ObjectId, ref: 'Product' }],
    hobbies: [{ type: Schema.Types.ObjectId, ref: 'Hobby' }],
    selection: { type: Schema.Types.ObjectId, ref: 'Product', required: false },
    community: { type: Schema.Types.ObjectId, ref: 'StoreCommunity', required: true },
    created_at: { type: Date, default: Date.now },
    store: { type: Schema.Types.ObjectId, ref: 'Store', required: false }
});

module.exports = mongoose.model('Consultation', ConsultationSchema);
