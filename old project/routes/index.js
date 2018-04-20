var express = require('express');
var ReactDOM = require('react-dom');
var React = require('react');
var router = express.Router();

/* GET home page. */
router.get('/', function (req, res, next) {
	res.render('index', { title: 'Server Side' });
});

module.exports = router;
