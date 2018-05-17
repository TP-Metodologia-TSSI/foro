<?php
namespace Vistas\Listar; 
require("../PartsTemplate/header.php");
?>

<header class="bg-white border border-bottom-dark">
	<div class="container py-3">
		<h1 class="h1 text-center">Nombre Foro</h1>
		<p class="text-secondary">Descripción el foro.....</p>
	</div>
</header>

<article class="py-4">
	<div class="container">
		<ul class="listContainer listStyleNone">
			<li class="border border-primary my-1 rounded-right">
				<div class="row">
					<aside class="col-3 col-xs-2 col-md-1 text-center">
						<a href="temasSubforo.php" class="fx">
							<i class="fa fa-arrow-circle-right fa-3x" aria-hidden="true"></i>
						</a>
					</aside>
					<article class="col-9 col-xs-10 col-md-11">
						<h4 class="p-0 m-0 h-100">Matematica</h4>
					</article>
				</div>
			</li>
			<li class="border border-primary my-1 rounded-right">
				<div class="row">
					<aside class="col-3 col-xs-2 col-md-1 text-center">
						<a href="temasSubforo.php" class="fx">
							<i class="fa fa-arrow-circle-right fa-3x" aria-hidden="true"></i>
						</a>
					</aside>
					<article class="col-9 col-xs-10 col-md-11">
						<h4 class="p-0 m-0 h-100">Laboratorio</h4>
					</article>
				</div>
			</li>
			<li class="border border-primary my-1 rounded-right">
				<div class="row">
					<aside class="col-3 col-xs-2 col-md-1 text-center">
						<a href="temasSubforo.php" class="fx">
							<i class="fa fa-arrow-circle-right fa-3x" aria-hidden="true"></i>
						</a>
					</aside>
					<article class="col-9 col-xs-10 col-md-11">
						<h4 class="p-0 m-0 h-100">Base de Datos</h4>
					</article>
				</div>
			</li>
			<li class="border border-primary my-1 rounded-right">
				<div class="row">
					<aside class="col-3 col-xs-2 col-md-1 text-center">
						<a href="temasSubforo.php" class="fx">
							<i class="fa fa-arrow-circle-right fa-3x" aria-hidden="true"></i>
						</a>
					</aside>
					<article class="col-9 col-xs-10 col-md-11">
						<h4 class="p-0 m-0 h-100">Ingles</h4>
					</article>
				</div>
			</li>
			<li class="border border-primary my-1 rounded-right">
				<div class="row">
					<aside class="col-3 col-xs-2 col-md-1 text-center">
						<a href="temasSubforo.php" class="fx">
							<i class="fa fa-arrow-circle-right fa-3x" aria-hidden="true"></i>
						</a>
					</aside>
					<article class="col-9 col-xs-10 col-md-11">
						<h4 class="p-0 m-0 h-100">Metodologia</h4>
					</article>
				</div>
			</li>	
		</ul>
	</div>
</article>	

<?php 
require("../PartsTemplate/footer.php");
?>
