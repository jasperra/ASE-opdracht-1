function toggle_visibility(id) {
    var e = document.getElementById(id);
    if(e.style.display == 'block'){
        e.style.display = 'none';
    } else {
        e.style.display = 'block';
    }
}

function changeField(id){
    var e = document.getElementById(id);
    if (e !== null && e.options[e.selectedIndex].value === "Onderhoudsbeurt") {
        document.getElementById("DT_monteur").style.display = 'block';
        document.getElementById("DT_uur").style.display = 'block';
        document.getElementById("DT_brandstofType").style.display = 'none';
        document.getElementById("DT_liter").style.display = 'none';
    } else if (e !== null && e.options[e.selectedIndex].value === "Tanken"){
        document.getElementById("DT_monteur").style.display = 'none';
        document.getElementById("DT_uur").style.display = 'none';
        document.getElementById("DT_brandstofType").style.display = 'block';
        document.getElementById("DT_liter").style.display = 'block';
    } else {
        document.getElementById("DT_monteur").style.display = 'none';
        document.getElementById("DT_uur").style.display = 'none';
        document.getElementById("DT_brandstofType").style.display = 'none';
        document.getElementById("DT_liter").style.display = 'none';
    }
};