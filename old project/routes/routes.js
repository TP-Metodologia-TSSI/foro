const express = require('express');

function setup(app, handlers) {

	// ########## Routes ##########

	// City Routers
	const cityRouter = express.Router();

	cityRouter.post('/', handlers.addCity.addCity);

	app.use('/api/city', cityRouter);

	const cityCommunityRouter = express.Router();

	cityCommunityRouter.post('/', handlers.addStoreCommunity.addStoreCommunity)

	app.use('/api/city/community', cityCommunityRouter);

	// Brand Routers

	const brandRouter = express.Router();

	brandRouter.post('/', handlers.addBrand.addBrand);
	brandRouter.get('/', handlers.getBrands.getBrands);

	app.use('/api/brand', brandRouter);

	// Consultation Routers

	const consultationRouter = express.Router();

	consultationRouter.post('/', handlers.addConsultation.addConsultation);

	app.use('/api/consultation', consultationRouter);

	// Category Routers

	const categoryRouter = express.Router();

	categoryRouter.post('/', handlers.addCategory.addCategory);
	categoryRouter.get('/', handlers.getCategories.getCategories);

	app.use('/api/category', categoryRouter);

	// Product Routers

	const productRouter = express.Router();

	productRouter.post('/', handlers.addProduct.addProduct);

	app.use('/api/product', productRouter);

	// Store Routers

	const storeProductRouter = express.Router();

	storeProductRouter.post('/', handlers.addStoreProduct.addStoreProduct);
	storeProductRouter.put('/', handlers.changeStoreProductPrice.changeStoreProductPrice);

	app.use('/api/store/product', storeProductRouter);

	// Store Community Routers

	const storeRouter = express.Router();

	storeRouter.post('/', handlers.addStore.addStore);

	app.use('/api/storeCommunity/store', storeRouter);

	// Subcategory Routers

	const subcategoryRouter = express.Router();

	subcategoryRouter.post('/', handlers.addSubcategory.addSubcategory);
	subcategoryRouter.get('/', handlers.getSubcategories.getSubcategories);

	app.use('/api/subcategory', subcategoryRouter);
};

exports.setup = setup;
