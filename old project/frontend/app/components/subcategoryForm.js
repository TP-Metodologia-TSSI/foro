const jwt = require('jsonwebtoken'),
	React = require('react'),
	urls = require('../vendors/urls.json');
import { postJson } from '../vendors/vendor';

export default class SubcategoryForm extends React.Component {
	constructor(props) {
		super(props);
		this.state = {
			nameValue: '', categories: []
		};
	}

	handleNameChange = (event) => {
		this.setState({ nameValue: event.target.value });
	}

	handleCategoriesChange = (event) => {
		var options = event.target.options;

		for (var i = 0, l = this.props.categories.length; i < l; i++) {
			if (options[i].selected) {
				this.state.categories.push(options[i].value)
			}
		}
	}

	handleSubmit = (event) => {

		const subcategoryData = { "name": this.state.nameValue, "categories": this.state.categories };
		postJson(urls.subcategory, subcategoryData);
		alert('A subcategory was submitted: ' + this.state.nameValue);
		event.preventDefault();
	}

	renderCategories() {
		return (
			<select value={this.state.categories} onChange={this.handleCategoriesChange} size="15" multiple>
				{this.props.categories.map((category) => (
					<option value={category._id}>{category.name}</option>
				))}
			</select>
		)
	}

	render() {
		return (
			<div>
				<h2>Subcategory Form</h2>
				<form>
					<span>
						Name: <input type="text" value={this.state.nameValue} onChange={this.handleNameChange} />
					</span><br />
					<span>
						Categories: {this.renderCategories()}
					</span><br />
					<span>
						<input type="button" value="Submit" onClick={this.handleSubmit} />
					</span>
				</form>
			</div>
		);
	}
}
