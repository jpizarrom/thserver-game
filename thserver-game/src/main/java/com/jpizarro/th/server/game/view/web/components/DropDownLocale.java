package com.jpizarro.th.server.game.view.web.components;

import java.util.List;
import java.util.Locale;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.IModel;

/**
 * Wicket Drop-down language / locale selector
 *
 * @author Eurig Jones
 */
public class DropDownLocale extends DropDownChoice<Locale>
{
   public DropDownLocale(String id, IModel<Locale> model, List locales)
   {
       super(id, model, locales);
       setChoiceRenderer(new LocaleChoiceRenderer());
   }
  
   @Override
   protected void onSelectionChanged(Locale newSelection)
   {
       getSession().setLocale(newSelection);
   }

   @Override
   protected boolean wantOnSelectionChangedNotifications()
   {
       return true;
   }

   private class LocaleChoiceRenderer implements IChoiceRenderer<Locale>
   {
       @Override
       public Object getDisplayValue(Locale locale)
       {
           // Change this to just locale.getDisplayLanguage() and it'll display the languages in the currently selected language / Locale and character set.
           return locale.getDisplayLanguage(locale);
       }

       @Override
       public String getIdValue(Locale locale, int i)
       {
           return locale.getLanguage();
       }
   }
}