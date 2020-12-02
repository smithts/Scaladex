function getPokemonNameForDex(id, hrefElementId) {
    var name = document.getElementById(id).value;
    if (name === "") {
        console.log("No Pokemon name provided")
        return;
    }

    document.getElementById(hrefElementId).setAttribute("href","pokedex3/" + name);
}

function getPokemonNamesForBattle(id1, id2, hrefElementId) {
    var name1 = document.getElementById(id1).value;
    var name2 = document.getElementById(id2).value;
    if (name1 === "" || name2 === "") {
        console.log("One or both Pokemon names not provided")
        return;
    }

    document.getElementById(hrefElementId).setAttribute("href","battle3/" + name1 + "," + name2);
}