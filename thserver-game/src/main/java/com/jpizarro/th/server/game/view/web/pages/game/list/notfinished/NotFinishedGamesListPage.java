package com.jpizarro.th.server.game.view.web.pages.game.list.notfinished;

//import org.wicketstuff.annotation.mount.MountPath;

import org.apache.wicket.authorization.strategies.role.annotations.AuthorizeInstantiation;

import com.jpizarro.th.server.game.view.web.pages.game.list.GamesListPage;

//@MountPath(path = "notFinishedGames")
@AuthorizeInstantiation( { "ROLE_USER", "ROLE_ADMIN"})
public class NotFinishedGamesListPage extends GamesListPage {

}
