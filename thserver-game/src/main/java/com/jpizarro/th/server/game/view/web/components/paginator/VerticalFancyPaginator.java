/*
 * Android Runner is a multiplayer GPS game fully written by "Xurxo Mendez Perez"
 * 
 * Copyright (C) 2009 "Xurxo Mendez Perez"
 *   
 * This file is part of Android Runner.
 * 
 * Android Runner is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Android Runner is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Android Runner.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jpizarro.th.server.game.view.web.components.paginator;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigationIncrementLink;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigationLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;

public class VerticalFancyPaginator extends Panel {
	private static final long serialVersionUID = 2668217261151422784L;

	public VerticalFancyPaginator(String id, final IPageable pageableList) {
		super(id);
		
		this.setOutputMarkupId(true);
		
		WebMarkupContainer paginatorBox = new WebMarkupContainer("paginatorBox"){
			private static final long serialVersionUID = -8245214604885147260L;

			@Override
			public boolean isVisible() {
				return pageableList.getPageCount()>1;
			}
		};
		this.add(paginatorBox);
		
		 
		PagingNavigationLink firstPageLink = new PagingNavigationLink("firstPageLink", pageableList, 0);
		paginatorBox.add(firstPageLink);
		PagingNavigationLink lastPageLink = new PagingNavigationLink("lastPageLink", pageableList, 
				pageableList.getPageCount()-1);
		lastPageLink.add(new Label("lastPageLabel", new Model(Integer.valueOf(pageableList.getPageCount()))));
		paginatorBox.add(lastPageLink);
		
		// Current page
		WebMarkupContainer currenPageItem = new WebMarkupContainer("currentPageItem"){
			private static final long serialVersionUID = -9186596865047783422L;
			@Override
			public boolean isVisible() {
				return pageableList.getCurrentPage()>=1 && 
					pageableList.getCurrentPage()!=pageableList.getPageCount()-1;
			}
		};
		currenPageItem.setOutputMarkupPlaceholderTag(true);
		currenPageItem.add(new Label("currentPageLabel", new LoadableDetachableModel(){
			private static final long serialVersionUID = 393829273382282502L;
			@Override
			protected Object load() {
				return Integer.valueOf( pageableList.getCurrentPage() + 1 );
			}
		}));
		paginatorBox.add(currenPageItem);
		
		// Previous and next links
		WebMarkupContainer previousPageItem = new WebMarkupContainer("previousPageItem"){
			private static final long serialVersionUID = -5827228260699397983L;

			@Override
			public boolean isVisible() {
				return pageableList.getCurrentPage()>0;
			}
		};
		previousPageItem.add( new PagingNavigationIncrementLink("previousPageLink", 
				pageableList, -1));
		previousPageItem.setOutputMarkupPlaceholderTag(true);
		paginatorBox.add(previousPageItem);
		
		WebMarkupContainer nextPageItem = new WebMarkupContainer("nextPageItem"){
			private static final long serialVersionUID = -5827228260699397983L;

			@Override
			public boolean isVisible() {
				return pageableList.getCurrentPage()<(pageableList.getPageCount()-1);
			}
		};
		nextPageItem.add( new PagingNavigationIncrementLink("nextPageLink", 
				pageableList, 1));
		nextPageItem.setOutputMarkupPlaceholderTag(true);
		paginatorBox.add(nextPageItem);
	}

}
