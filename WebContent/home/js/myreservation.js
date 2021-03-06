/*
 * Helene Akulow
 */

"use strict";

document.addEventListener("DOMContentLoaded",init);

function init(){
	//Einzeltermine löschen auch bei den Wdhterminen
	var deletelink = document.getElementsByClassName("deletelink");
	
	
    for (var i = 0; i < deletelink.length; i++) {
    	deletelink[i].addEventListener("click", confirmDeleteLink);
    }
    //Alle Terminbezeichnung und alle dazugehörigen Einzeltermine löschen
	var deletewdhtermin = document.getElementsByClassName("deletewdhtermin");
	
	
    for (var i = 0; i < deletewdhtermin.length; i++) {
    	deletewdhtermin[i].addEventListener("click", confirmDeleteWdh);
    }
    //Auf- und zuklappen der Termine zu den Bezeichnungen
    var terminbez = document.getElementsByClassName("terminbez");
    
    for (var i = 0; i < terminbez.length; i++) {
    	terminbez[i].addEventListener("click", showAndHide);
    	
    }
	
}

//Standardaktionen des Browsers unterbinden:
function confirmDeleteLink(evt){
	var deletebox = confirm("Wollen Sie diesen Einzeltermin wirklich löschen?");
	
	if(!deletebox){
		evt.preventDefault();
	}
}

function confirmDeleteWdh(evt){
	var terminBez = this.getAttribute("id").replace('delete','');
	
	var deletebox = confirm("Wollen Sie wirklich alle Einzeltermine mit\n der Terminbezeichnung '" + terminBez+"' löschen?");
	
	if(!deletebox){
		evt.preventDefault();
	}
};

function showAndHide(){
		
	if(document.getElementById(this.getAttribute("id")+"_table").className === "hiddentable"){
		document.getElementById(this.getAttribute("id")+"_table").classList.remove("hiddentable");
		document.getElementById(this.getAttribute("id")+"_pfeil").innerHTML = "▼";
		
	}
	else{
		document.getElementById(this.getAttribute("id")+"_table").className = "hiddentable";
		document.getElementById(this.getAttribute("id")+"_pfeil").innerHTML = "▲";
	}
}