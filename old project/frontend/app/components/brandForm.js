const jwt = require('jsonwebtoken'),
	React = require('react'),
	ReactDOM = require('react-dom'),
	urls = require('../vendors/urls.json');
import { postJson } from '../vendors/vendor';

export default class BrandForm extends React.Component {
	constructor(props) {
		super(props);
		this.state = { nameValue: '', descriptionValue: '' };
	}

	handleNameChange = (event) => {
		this.setState({ nameValue: event.target.value });
	}

	handleDescriptionChange = (event) => {
		this.setState({ descriptionValue: event.target.value });
	}

	handleSubmit = (event) => {
		const brandData = { "name": this.state.nameValue, "description": this.state.description };
		postJson(urls.brand, brandData);
		alert('A brand was submitted: ' + this.state.nameValue);
		event.preventDefault();
	}

	render() {
		return (
			<div>
				<h2>Brand Form</h2>
				<form id='form'>
					<span>
						Name: <input type="text" value={this.state.nameValue} onChange={this.handleNameChange} />
					</span><br />
					<span>
						Description: <input type="text" value={this.state.descriptionValue} onChange={this.handleDescriptionChange} />
					</span><br />
					<span>
						<input type="button" value="Submit" onClick={this.handleSubmit} />
					</span>
				</form>
			</div>
		);
	}
}

exports.BrandForm = BrandForm;
