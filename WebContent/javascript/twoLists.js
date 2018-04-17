$(function () {
    $('#btnRight').click(function (e) {
    	
        var selectedOpts = $('#lstBox1 option:selected');
        if (selectedOpts.length == 0) {
            alert("Nada para mover");
            e.preventDefault();
        }

        $('#lstBox2').append($(selectedOpts).clone());
        $('#coordinador').append($(selectedOpts).clone());
        $(selectedOpts).remove();
        selectedOpts = $('#lstBox2 option');
        $('#lstBox3').empty();
        $('#lstBox3').append($(selectedOpts).clone());
        $('#lstBox3 option').prop('selected', true);
        e.preventDefault();
    });


    $('#btnLeft').click(function (e) {
    	
        var selectedOpts = $('#lstBox2 option:selected');
        if (selectedOpts.length == 0) {
            alert("Nada para mover");
            e.preventDefault();
        }
        
        $('#lstBox1').append($(selectedOpts).clone());
        $('#coordinador').empty();
        $('#coordinador').append('<option value="" disabled selected>Elija Coordinador</option>');
        $(selectedOpts).remove();
        selectedOpts = $('#lstBox2 option');
        $('#lstBox3').empty();
        $('#lstBox3').append($(selectedOpts).clone());
        $('#lstBox3 option').prop('selected', true);
        $('#coordinador').append($(selectedOpts).clone());
        e.preventDefault();
    });

    
})