/*
 * Copyright (C) 2013 Chris Lacy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.appdotnet4j.model;

import org.tjson.JSONException;
import org.tjson.JSONObject;


public class AdnUser {
	
	public long mId;
	public String mUserName;
	public String mName;
	public String mDescription;
	public int mFollowersCount;
	public int mFollowingCount;
	public int mPostCount;
	public String mAvatarUrl;
	public String mCoverUrl;
	
	public AdnUser(String jsonAsString) {
		try {
			JSONObject object = new JSONObject(jsonAsString);
			mId = object.getLong("id");
			mUserName = object.getString("username");
			mName = object.getString("name");

			if (object.has("description")) {
				try {
					JSONObject description = object.getJSONObject("description");
					mDescription = description.getString("text");
				} catch (JSONException e) {}
			}
			
			if (object.has("counts")) {
				JSONObject counts = object.getJSONObject("counts");
				mFollowersCount = counts.getInt("followers");
				mFollowingCount = counts.getInt("following");
				mPostCount = counts.getInt("posts");
			}
			
			if (object.has("avatar_image")) {
				JSONObject avatar = object.getJSONObject("avatar_image");
				mAvatarUrl = avatar.getString("url");
			}
			
			if (object.has("cover_image")) {
				JSONObject cover = object.getJSONObject("cover_image");
				mCoverUrl = cover.getString("url");
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
}
