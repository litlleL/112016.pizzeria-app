import _ from 'lodash';

export class PanierService {
    constructor($localStorage, PizzaService, BoissonService, $q, DessertService) {

        this.$localStorage = $localStorage;
        this.BoissonService = BoissonService;
        this.DessertService = DessertService;
        this.PizzaService = PizzaService;
        this.$q = $q;
    }

    getProduits() {

        return this.PizzaService.getPizzas()
            .then(pizzas =>
                this.BoissonService.getBoissons()
                    .then(boissons =>
                            this.DessertService.getDesserts()
                            .then(desserts =>
                            this.prodList = _.concat(pizzas, boissons, desserts)
                        )
                    ) 
            )

    }

    initPanier() {

        this.$localStorage.jsonPanier = this.$localStorage.jsonPanier || [];

        return this.$localStorage.jsonPanier;
    }

    ajouterElement(element) {

        if (this.$localStorage.jsonPanier === undefined)
            this.initPanier();

        let panier = this.$localStorage.jsonPanier;

        let exist = _.find(panier, e => (e.idProduit === element.id && e.type === element.type));

        if (exist !== undefined) {
            ++exist.quantite;
        } else {
            let ajout = {};

            ajout.type = element.type;
            ajout.idProduit = element.id;
            ajout.quantite = 1;
            panier.push(ajout);
        }

    }


    resetPanier() {

        delete this.$localStorage.jsonPanier;

    }

    getPanier() {

        return this.$localStorage.jsonPanier || this.initPanier();
    }
}
