Narrative:
Comme un porteur de carte émise par une banque française
Je veux faire un paiement à l'étranger
Pour payer facilement à l'étranger

Scénario: paiement - succès
Etant donné que le porteur Jérémie Grodziski possède la carte no 1234 5678 9012 3456 en EUR et un débit de 0 EUR associé au compte bancaire 300003 03594 00051524344 12 avec un solde de 1000 € à la banque Société Générale
Etant donné que le service ExchangeService est initialisé avec le taux du jour 0.82 pour EUR-CHF
Quand le porteur effectue un paiement chez un commerçant de 100 CHF
Alors les frais calculé sont de 1.23 EUR (voir Frais)
Alors le débit de la carte est de 83.23 EUR

Scénario: paiement - succès
Etant donné que le porteur Jérémie Grodziski possède la carte no 1234 5678 9012 3456 en GBP et un débit de 0 GBP associé au compte bancaire 300003 03594 00051524344 12 avec un solde de 1000 € à la banque Barclays
Etant donné que le service ExchangeServiceCHF-EUR est initialisé avec le taux du jour 0.82 pour EUR-CHF
Etant donné que le service ExchangeServiceGBP-EURr est initialisé avec le taux du jour 1.26 pour EUR-GBP
Quand le porteur effectue un paiement chez un commerçant de 100 CHF
Alors les frais calculé sont de 1.23 GBP (voir Frais)
Alors le débit de la carte est de 83.23 GBP