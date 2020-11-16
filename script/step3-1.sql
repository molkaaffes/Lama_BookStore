CREATE TABLE `clients` (
  `id` int(11) NOT NULL,
  `nom` varchar(10) NOT NULL,
  `prenom` varchar(10) NOT NULL,
  `email` varchar(20) NOT NULL,
  `tel` varchar(20) NOT NULL,
  `adresse` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `clients`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `clients`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;


CREATE TABLE `commandes` (
  `id` int(11) NOT NULL,
  `date_commande` date NOT NULL,
  `qte` int(11) NOT NULL,
  `id_produit` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `prix_unit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


ALTER TABLE `commandes`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `commandes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;
