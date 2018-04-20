const jwt = require('jsonwebtoken'),
	React = require('react');

export default class ProductForm extends React.Component {
	constructor(props) {
		super(props);
		this.state = {
			nameValue: '', descriptionValue: '', brandValue: '', subcategoryValue: ''
		};
	}

	handleNameChange = (event) => {
		this.setState({ nameValue: event.target.value });
	}

	handleDescriptionChange = (event) => {
		this.setState({ descriptionValue: event.target.value });
	}

	handleBrandChange = (event) => {
		this.setState({ brandValue: event.target.value });
	}

	handleSubcategoryChange = (event) => {
		this.setState({ subcategoryValue: event.target.value });
	}

	handleSubmit = (event) => {
		const productData = {
			"name": this.state.nameValue,
			"subcategory": this.state.subcategoryValue,
			"brand": this.state.brandValue,
			"description": this.state.descriptionValue
		};
		postJson(urls.product, productData);
		alert('A product was submitted: ' + this.state.nameValue);
		event.preventDefault();
	}

	renderBrand() {
		return (
			<select value={this.state.brandValue} onChange={this.handleBrandChange}>
				{this.props.brands.map((brand) => (
					<option value={brand._id}>{brand.name}</option>
				))}
			</select>
		)
	}

	renderSubcategory() {
		return (
			<select value={this.state.subcategoryValue} onChange={this.handleSubcategoryChange}>
				{this.props.subcategories.map((subcategory) => (
					<option value={subcategory._id}>{subcategory.name}</option>
				))}
			</select>
		)
	}

	render() {
		return (
			<div>
				<h2>Product Form</h2>
				<form>
					<span>
						Name: <input type="text" value={this.state.nameValue} onChange={this.handleNameChange} />
					</span><br />
					<span>
						Description: <input type="text" value={this.state.descriptionValue} onChange={this.handleDescriptionChange} />
					</span><br />
					<span>
						Subcategory: {this.renderSubcategory()}
					</span><br />
					<span>
						Brand: {this.renderBrand()}
					</span><br />
					<span>
						<input type="button" value="Submit" onClick={this.handleSubmit} />
					</span>
				</form>
			</div>
		);
	}
}
