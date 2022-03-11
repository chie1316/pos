/**
 * 
 */

$(document).ready(function() {
	openModal();
});

function openModal() {
	$('.eBtn').on('click', function(event) {
		$('.createOrUpdateProductForm #exampleModal').modal("show");
	});
}