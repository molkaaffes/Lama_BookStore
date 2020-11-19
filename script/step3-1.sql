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
  `datecommande` date NOT NULL,
  `qte` int(11) NOT NULL,
  `idproduit` int(11) NOT NULL,
  `idclient` int(11) NOT NULL,
  `prixunit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


ALTER TABLE `commandes`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `commandes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;


ALTER TABLE 'clients' ADD pwd varchar(10) NOT NULL;