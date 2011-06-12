package fluency

new Order(
        itemName: 'lattes',
        quantity: 2
).pay(Currency.getInstance('USD'))

new Order().with {
    itemName = 'lattes'
    quantity = 2
    pay(Currency.getInstance("USD"))
}
