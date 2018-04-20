import React, { Component } from 'react';
import BrandForm from './brandForm';
import ProductForm from './productForm';
import SubcategoryForm from './subcategoryForm';
import { getJson } from '../vendors/vendor';
const urls = require('../vendors/urls.json');

export default class App extends Component {
  constructor(props) {
    super(props);

    //var Httpreq = new XMLHttpRequest(); // a new request
    //Httpreq.send(null);

    var brandResponse = getJson(urls.brand);
    var subcategoryResponse = getJson(urls.subcategory);
    var categoryResponse = getJson(urls.category);

    this.state = {
      subcategories: subcategoryResponse,
      brands: brandResponse,
      categories: categoryResponse
    };
  }

  render() {
    return (
      <div>
        <BrandForm />
        <ProductForm
          brands={this.state.brands}
          subcategories={this.state.subcategories}
        />
        <SubcategoryForm
          categories={this.state.categories}
        />
      </div>
    );
  }
}
