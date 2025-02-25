package org.joinmastodon.android.ui.displayitems;

import android.app.Activity;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.joinmastodon.android.R;
import org.joinmastodon.android.fragments.BaseStatusListFragment;
import org.joinmastodon.android.model.Status;
import org.joinmastodon.android.ui.drawables.SpoilerStripesDrawable;
import org.joinmastodon.android.ui.text.HtmlParser;
import org.joinmastodon.android.ui.utils.CustomEmojiHelper;
import org.joinmastodon.android.ui.views.LinkedTextView;

import me.grishka.appkit.imageloader.ImageLoaderViewHolder;
import me.grishka.appkit.imageloader.MovieDrawable;
import me.grishka.appkit.imageloader.requests.ImageLoaderRequest;
import me.grishka.appkit.utils.V;

public class TextStatusDisplayItem extends StatusDisplayItem{
	private CharSequence text;
	private CustomEmojiHelper emojiHelper=new CustomEmojiHelper(), spoilerEmojiHelper;
	private CharSequence parsedSpoilerText;
	public boolean textSelectable;
	public final Status status;

	public TextStatusDisplayItem(String parentID, CharSequence text, BaseStatusListFragment parentFragment, Status status){
		super(parentID, parentFragment);
		this.text=text;
		this.status=status;
		emojiHelper.setText(text);
		if(!TextUtils.isEmpty(status.spoilerText)){
			parsedSpoilerText=HtmlParser.parseCustomEmoji(status.spoilerText, status.emojis);
			spoilerEmojiHelper=new CustomEmojiHelper();
			spoilerEmojiHelper.setText(parsedSpoilerText);
		}
	}

	@Override
	public Type getType(){
		return Type.TEXT;
	}

	@Override
	public int getImageCount(){
		if(spoilerEmojiHelper!=null && !status.spoilerRevealed)
			return spoilerEmojiHelper.getImageCount();
		return emojiHelper.getImageCount();
	}

	@Override
	public ImageLoaderRequest getImageRequest(int index){
		if(spoilerEmojiHelper!=null && !status.spoilerRevealed)
			return spoilerEmojiHelper.getImageRequest(index);
		return emojiHelper.getImageRequest(index);
	}

	public static class Holder extends StatusDisplayItem.Holder<TextStatusDisplayItem> implements ImageLoaderViewHolder{
		private final LinkedTextView text;
		private final LinearLayout spoilerHeader;
		private final TextView spoilerTitle, spoilerTitleInline;
		private final View spoilerOverlay, borderTop, borderBottom;
		private final Drawable backgroundColor, borderColor;

		public Holder(Activity activity, ViewGroup parent){
			super(activity, R.layout.display_item_text, parent);
			text=findViewById(R.id.text);
			spoilerTitle=findViewById(R.id.spoiler_title);
			spoilerTitleInline=findViewById(R.id.spoiler_title_inline);
			spoilerHeader=findViewById(R.id.spoiler_header);
			spoilerOverlay=findViewById(R.id.spoiler_overlay);
			borderTop=findViewById(R.id.border_top);
			borderBottom=findViewById(R.id.border_bottom);
			itemView.setOnClickListener(v->item.parentFragment.onRevealSpoilerClick(this));

			TypedValue outValue=new TypedValue();
			activity.getTheme().resolveAttribute(R.attr.colorBackgroundLight, outValue, true);
			backgroundColor=activity.getDrawable(outValue.resourceId);
//			activity.getTheme().resolveAttribute(R.attr.colorBackgroundLightest, outValue, true);
//			backgroundColorInset=activity.getDrawable(outValue.resourceId);
			activity.getTheme().resolveAttribute(R.attr.colorPollVoted, outValue, true);
			borderColor=activity.getDrawable(outValue.resourceId);
		}

		@Override
		public void onBind(TextStatusDisplayItem item){
			text.setText(item.text);
			text.setTextIsSelectable(item.textSelectable);
			spoilerTitleInline.setTextIsSelectable(item.textSelectable);
			text.setInvalidateOnEveryFrame(false);
			spoilerTitleInline.setBackground(item.inset ? null : backgroundColor);
			spoilerTitleInline.setPadding(spoilerTitleInline.getPaddingLeft(), item.inset ? 0 : V.dp(14), spoilerTitleInline.getPaddingRight(), item.inset ? 0 : V.dp(14));
			borderTop.setBackground(item.inset ? null : borderColor);
			borderBottom.setBackground(item.inset ? null : borderColor);
			if(!TextUtils.isEmpty(item.status.spoilerText)){
				spoilerTitle.setText(item.parsedSpoilerText);
				spoilerTitleInline.setText(item.parsedSpoilerText);
				if(item.status.spoilerRevealed){
					spoilerOverlay.setVisibility(View.GONE);
					spoilerHeader.setVisibility(View.VISIBLE);
					text.setVisibility(View.VISIBLE);
					itemView.setClickable(false);
				}else{
					spoilerOverlay.setVisibility(View.VISIBLE);
					spoilerHeader.setVisibility(View.GONE);
					text.setVisibility(View.GONE);
					itemView.setClickable(true);
				}
			}else{
				spoilerOverlay.setVisibility(View.GONE);
				spoilerHeader.setVisibility(View.GONE);
				text.setVisibility(View.VISIBLE);
				itemView.setClickable(false);
			}
		}

		@Override
		public void setImage(int index, Drawable image){
			getEmojiHelper().setImageDrawable(index, image);
			text.invalidate();
			spoilerTitle.invalidate();
			if(image instanceof Animatable){
				((Animatable) image).start();
				if(image instanceof MovieDrawable)
					text.setInvalidateOnEveryFrame(true);
			}
		}

		@Override
		public void clearImage(int index){
			getEmojiHelper().setImageDrawable(index, null);
			text.invalidate();
		}

		private CustomEmojiHelper getEmojiHelper(){
			return item.spoilerEmojiHelper!=null && !item.status.spoilerRevealed ? item.spoilerEmojiHelper : item.emojiHelper;
		}
	}
}
