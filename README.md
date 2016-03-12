Titris
======
http://codes-sources.commentcamarche.net/source/54913-tetris-like-1-ou-2-joueurs-en-java

Titris-Like 1 or 2 players 

Partie à un joueur 
Règles du jeu 
Une partie à un joueur est une course au score, c’est-à-dire au plus grand nombre de lignes constituées. De façon générale, un Tetris est une forme de casse-brique se déroulant dans une zone de jeu rectangulaire. La taille de cette zone est déterminée en nombre de briques, objet élémentaire de forme carrée. La figure ci-contre représente l’aire de jeu, généralement une matrice rectangulaire de 10 briques de largeur par 22 briques de hauteur. 
La zone est initialement vide. Le jeu consiste à empiler des pièces composées de 4 briques dont les différentes formes géométriques sont les suivantes : 
Les pièces arrivent une par une par le haut de la zone et chutent progressivement vers le bas de la zone. La forme de la pièce est choisie aléatoirement parmi les sept possibles. Les possibilités d’interaction pour déplacer la pièce en cours sont décrites dans la section Gameplay (notez que le point noir figurant sur chaque pièce montre le centre de la rotation). La pièce cesse de chuter si l’une de ses briques constituantes rencontre une brique déjà présente dans la zone ou le bas de la zone ; une nouvelle pièce apparaît en haut de la zone. La vitesse de descente des pièces correspond à la difficulté ; on considérera 10 niveaux de difficulté tels que pour une difficulté i, les pièces tombent à la vitesse de i briques par seconde. Lorsqu’une ligne de briques (c’est-à-dire lorsqu’une rangée est couverte de briques sur toute la largeur de la zone), le score est incrémenté de i points (i étant la difficulté courante) et la ligne disparaît ; ces disparitions occasionnent alors la chute de toutes les briques situées au-dessus d’un cran vers le bas. 
Si quatre lignes superposées sont supprimées d’un coup, il s’agit alors d’un Tetris, et le score s’incrémente de 10*i points supplémentaires. Une fois la barre des 100 lignes passée, la difficulté augmente de 1. Pour terminer, le joueur perd s’il n’y a plus de place dans la zone pour faire apparaître la pièce suivante. 
Interface graphique 
L’interface du joueur est composée de quatre éléments : 
1. la zone de jeu rectangulaire 
2. la pièce suivante 
3. le niveau de difficulté courant 
4. le score actuel 
On pourra par exemple respecter la convention graphique ci-contre. 
Gameplay 
Le joueur a la possibilité de faire déplacer la pièce courante d’un cran vers la droite (bouton RIGHT), d’un cran vers la gauche (bouton LEFT), d’effectuer une rotation vers la droite (bouton ROTATE) ou d’accélérer la descente (bouton DOWN). Concrètement, à chaque pression du bouton RIGHT (resp. LEFT), la pièce se déplace d’une brique sur la droite (resp. sur la gauche). Lorsque le bouton DOWN est enfoncé, la vitesse de chute passe momentanément à 40 briques par seconde ; lorsque le bouton est relâché, la vitesse de chute revient à la normale. Les touches du clavier associées aux différents boutons LEFT, RIGHT, ROTATE et DOWN sont paramétrables par le menu d’option (cf. le paragraphe Gestion des options). 
En appuyant sur la touche Échap du clavier, le jeu est mis en pause et 3 fonctionnalités sont proposées : 
1. Reprendre le jeu 
2. Gérer les options du jeu (cf. le paragraphe Gestion des options) 
3. Revenir à l’écran titre (c’est-à-dire quitter la partie courante) 
Partie à deux joueurs 
Règles du jeu 
A deux joueurs, l’objectif n’est plus une course au score mais de tenir le plus longtemps possible face à l’adversaire. La séquence de pièces est évidemment la même pour les deux joueurs pour préserver une certaine équité. Cependant, pour corser un peu l’intérêt du jeu, un système de couleurs sera utilisé pour les briques. Ainsi si une ligne construite par l’un des joueurs contient 5 briques consécutives de même couleur, cette ligne réapparaîtra en bas de la zone de jeu de l’autre joueur causant la montée de l’ensemble des constructions de ce joueur. Cette pénalisation se fera au moment du changement de pièce courante. Le jeu de couleurs des briques est composé de 5 couleurs paramétrables (cf. le paragraphe Gestion des options).

