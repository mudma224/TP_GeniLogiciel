const mongoose = require('mongoose');

const commandeSchema = new mongoose.Schema({
  produit: String,
  quantite: Number,
  prix: Number,
  date: {
    type: Date,
    default: Date.now
  }
});

module.exports = mongoose.model('commande', commandeSchema);