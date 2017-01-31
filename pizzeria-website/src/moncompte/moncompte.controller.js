import lodash from 'lodash';

export default class MonCompteController {

    constructor(UserService, $routeParams, $location, CommandeService) {

        this.UserService = UserService;
        this.CommandeService = CommandeService;

        this.id = $routeParams.id;
        this.$location = $location;

    }

    $onInit() {
        this.commandes = [];
        this.UserService.getUser(this.id)
            .then(user => this.user = user[0]);

        this.CommandeService.getCommandeByUserId(this.id)
            .then(commandes =>{
                lodash(commandes.map(commande => {
                   commande.date = Date(commande.date)
                   this.commandes.push(commande)
                }))
                .flatten()
            })
            
        this.disable = true;

    }

    updateInfo() {

        this.disable = false;

    }

    saveUser(form, user) {
        if (form.$invalid) return;
        this.UserService.saveUser(user)
            .then(() => this.$location.path('/moncompte/' + user.id));

        this.disable = true;
    }

    annulerUpdate() {

        this.disable = true;
         this.UserService.getUser(this.id)
            .then(user => this.user = user[0]);

    }

    voirCommande(idCommande){
        console.log(idCommande)
    }
}