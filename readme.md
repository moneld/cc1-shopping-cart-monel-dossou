Au lancement de l'application, deux items sont ajoutés dans le panier.

Les différents endpoint pour tester l'application

Pour lister les items
 `GET : /api/v1/cart`

Pour ajouter un item
`POST : /api/v1/cart`

Pour valider le panier
`PATCH : /api/v1/cart/validate/{cartId}`

Pour annuler le panier
`PATCH : /api/v1/cart/canceled/{cartId}`