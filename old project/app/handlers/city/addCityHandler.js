const jwt = require('jsonwebtoken'),
  config = require('../../../config').config(),
  City = require('../../models/city');

function addCity(req, res) {
  const city = new City();
  city.name = req.body.name;
  city.description = req.body.description;
  city.communities = [];

  city.save(function (err) {
     if (err) {
       console.log(err);
       return err;
     };
  });

  console.log('Si');

  res.json({
    message: 'City added.'
  });
}

exports.addCity = addCity;
