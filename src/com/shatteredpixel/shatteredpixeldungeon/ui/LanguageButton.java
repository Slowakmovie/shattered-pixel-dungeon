/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015  Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2015 Evan Debenham
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package com.shatteredpixel.shatteredpixeldungeon.ui;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.ShatteredPixelDungeon;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.TitleScene;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndOptions;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndSettings;
import com.watabou.noosa.Image;
import com.watabou.noosa.RenderedText;
import com.watabou.noosa.audio.Sample;
import com.watabou.noosa.ui.Button;

public class LanguageButton extends Button {

	private Image image;

	public LanguageButton() {
		super();

		width = image.width;
		height = image.height;
	}

	@Override
	protected void createChildren() {
		super.createChildren();

		image = Icons.INFO.get();
		add( image );
	}

	@Override
	protected void layout() {
		super.layout();

		image.x = x;
		image.y = y;
	}

	@Override
	protected void onTouchDown() {
		image.brightness( 1.5f );
		Sample.INSTANCE.play( Assets.SND_CLICK );
	}

	@Override
	protected void onTouchUp() {
		image.resetColor();
	}

	@Override
	protected void onClick() {
		parent.add( new WndOptions("Languages", "Select a language(proper menu soon)", "English", "Русский язык(99%)", "Português(99%)", "中文(99%)", "한국어(99%)", "Deutsch(93%)", "Polski(55%)", "Français(40%)", "Español(40%)" ) {
			@Override
			protected void onSelect(int index) {
				switch(index){
					case 0:
						Messages.setup("");
						break;
					case 1:
						Messages.setup("ru");
						break;
					case 2:
						Messages.setup("pt");
						break;
					case 3:
						Messages.setup("zh");
						break;
					case 4:
						Messages.setup("ko");
						break;
					case 5:
						Messages.setup("de");
						break;
					case 6:
						Messages.setup("pl");
						break;
					case 7:
						Messages.setup("fr");
						break;
					case 8:
						Messages.setup("es");
				}
				ShatteredPixelDungeon.switchNoFade(TitleScene.class);
				RenderedText.clearCache();
			}
		});
	}
}
