/*
Controls and stores emotion counts mostly use addCount and removeCount as they
increment/deincrement counts

Copyright 2018 Jason Robock

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */
package com.example.jason.jrobock_feelsbook;

import java.util.Collection;
import java.util.Iterator;

public class EmotionCounts {
    protected static int[] emotionCounts =  new int[] {0,0,0,0,0,0};
    static public int[] getEmotionCounts() {
        return emotionCounts;
    }

    static public void removeCount(String type) {
        switch (type){
            case "Love" : emotionCounts[0]--;
                        break;
            case "Joy" : emotionCounts[1]--;
                        break;
            case "Surprise" : emotionCounts[2]--;
                            break;
            case "Anger" : emotionCounts[3]--;
                        break;
            case "Sadness" : emotionCounts[4]--;
                        break;
            case "Fear" : emotionCounts[5]--;
                        break;
        }

    }

    static public void addCount(String type) {
        switch (type){
            case "Love" : emotionCounts[0]++;
                          break;
            case "Joy" : emotionCounts[1]++;
                         break;
            case "Surprise" : emotionCounts[2]++;
                            break;
            case "Anger" : emotionCounts[3]++;
                            break;
            case "Sadness" : emotionCounts[4]++;
                        break;
            case "Fear" : emotionCounts[5]++;
                        break;
        }
    }
    /*
    this shits broken will fix tomrrow
     */
    static public void initialize() {
       for(Emotion em : EmotionListController.getEmotionList().emotionList){
           addCount(em.getType());
        }
    }


}
