<?php 
namespace Vistas\Tema;
require("../PartsTemplate/header.php");
?>

<section class="container">
	
	<article id="temaPrincipal" class="my-3">
		
		<div class="row">

			<section class="col-8 col-md-10 bg-white border-hr rounded">

				<header class="border-bottom-hr py-2">
					<h3 class="d-inline">Título del tema</h3>
					<?php  
						if (true) {
							echo '<a href="#responderTema" class="btn btn-success pull-right">Responder</a>';
						
						}	else {
							echo '<a href="#login" class="btn btn-success pull-right">Responder</a>';

						}
					?>
				</header>

				<article class="messageContainer">
Descripción del tema planteadooooooooooooooooooooooooooooooo ooooooooooooooooooooooooooooooooooooooooo
easd
dgfd
cb
b
vcb

gh
hd
				</article>	
			</section>

			<aside class="col-4 col-md-2 text-center">
				<div class="bg-white border-hr rounded h-auto">
					<header class="py-4">
						<i class="fa fa-user-circle-o fa-4x" aria-hidden="true"></i>
					</header>

					<ul class="listStyleNone">
						<li>
							<label>User name</label>
						</li>
						<li>
							<label>Post created on 11/05/2018</label>
						</li>
					</ul>
				</div>
			</aside>			
		</div>

	</article>

	<article class="media my-3">
		<section class="media-body p-4 bg-white border-hr rounded">
			<article class="messageContainer">Respuesta #1
			</article>	
		</section>

		<aside class="align-self-center text-center border-left-hr py-2 px-4 ml-3 bg-white border-hr rounded">
			<header class="mb-1">
				<i class="fa fa-user-circle-o fa-4x" aria-hidden="true"></i>
			</header>
			<label>User name</label>
		</aside>			
	</article>

	<article class="media my-3">
		<section class="media-body p-4 bg-white border-hr rounded">
			<article class="messageContainer">Respuesta #2
			</article>	
		</section>

		<aside class="align-self-center text-center border-left-hr py-2 px-4 ml-3 bg-white border-hr rounded">
			<header class="mb-1">
				<i class="fa fa-user-circle-o fa-4x" aria-hidden="true"></i>
			</header>
			<label>User name</label>
		</aside>			
	</article>

	<article class="media my-3">
		<section class="media-body p-4 bg-white border-hr rounded">
			<article class="messageContainer">Respuesta #3
			</article>	
		</section>

		<aside class="align-self-center text-center border-left-hr py-2 px-4 ml-3 bg-white border-hr rounded">
			<header class="mb-1">
				<i class="fa fa-user-circle-o fa-4x" aria-hidden="true"></i>
			</header>
			<label>User name</label>
		</aside>			
	</article>

	<article class="media my-3">
		<section class="media-body p-4 bg-white border-hr rounded">
			<article class="messageContainer">Respuesta #4
			</article>	
		</section>

		<aside class="align-self-center text-center border-left-hr py-2 px-4 ml-3 bg-white border-hr rounded">
			<header class="mb-1">
				<i class="fa fa-user-circle-o fa-4x" aria-hidden="true"></i>
			</header>
			<label>User name</label>
		</aside>			
	</article>

	<article class="media my-3">
		<section class="media-body p-4 bg-white border-hr rounded">
			<article class="messageContainer">Respuesta #5
			</article>	
		</section>

		<aside class="align-self-center text-center border-left-hr py-2 px-4 ml-3 bg-white border-hr rounded">
			<header class="mb-1">
				<i class="fa fa-user-circle-o fa-4x" aria-hidden="true"></i>
			</header>
			<label>User name</label>
		</aside>			
	</article>

	<?php 
	if(true) {
		echo '
			<article id="responderTema">
				<header>
					<h3>Redactá tu respuesta...</h3>
				</header>
				<form action="" method="POST">
					<textarea name="respuestaTema" class="form-control" rows="5"></textarea>
					<div class="my-2 text-right">
						<input type="submit" name="btnSendRepuestaTema" class="btn btn-success" value="Enviar">
					</div>
				</form>
			</article>
			';
	}
	?>
</section>

<?php  
require("../PartsTemplate/footer.php");
?>