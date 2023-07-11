package com.kh.musicprogram.controller;

import java.util.ArrayList;
import java.util.List;

import com.kh.musicprogram.model.vo.Music;


public class MusicController {
	// 출력하는 곳이기 때문에 List 사용
	List<Music> mList;
	
	public MusicController() {
		mList = new ArrayList<>();
	}
	
	// 메소드를 완성 후 자바 독 주석을 달면 어떤 메소드 사용했는지 알 수 있음!
	// 입력받은걸 받아서 추가해야하기 때문에 매개변수가 필요함.
	/**
	 * 마지막 위치에 곡 추가
	 * @param music
	 */
	public void addAtLast(Music music) {
		mList.add(music);
	}
	
	/**
	 *  첫 위치에 곡 추가
	 * @param music
	 */
	public void addAtZero(Music music) {
		mList.add(0, music);
	}
	/**
	 * 곡 수정하기
	 * @param index
	 * @param music
	 */
	public void updateMusic(int index, Music music) {
		mList.set(index, music);
	}

	/**
	 * 곡 삭제하기
	 * @param title
	 */
	public void removeMusic(int i) {
		// mList에서 삭제
		mList.remove(i);
	}

	/**
	 * 음악 전체 정보 출력
	 * @return mList
	 */
	public List<Music> printMusicList() {
		return mList;
	}
	/**
	 * 곡이름으로 음악 검색
	 * @param title
	 * @return
	 */
	public List<Music> searchMusicByName(String title) {
		// 찾은 음악을 담을 리스트
		List<Music> findList = new ArrayList<Music>();
		// 기존 음악이 있는 mList 에서 찾기
		for(Music mOne : mList) {
			// 입력한 이름이 같으면
			if(mOne.getTitle().equals(title)) {
				// findList 에 추가하기
				findList.add(mOne);
			}
		}
		// 다 찾으면 리턴하기
		return findList;
	}
	/**
	 * 이름으로 곡 검색하기
	 * @param title
	 * @return
	 */
	public int searchOneByTitle(String title) {
		for(int i = 0; i < mList.size(); i++) {
			Music music = mList.get(i);
			if(music.getTitle().equals(title)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * 삽입정렬로 곡 오름차순 연습
	 */
	public void insertionSortByTitleASC() {
		for(int i = 1; i < mList.size(); i++) {
			for(int j = i; j > mList.size(); j--) {
				Music mOne = mList.get(j);
				Music mTwo = mList.get(j-1);
				if(mOne.getTitle().compareTo(mTwo.getTitle()) > 0) {
					Music temp = mTwo;
					mList.set(j-1, mOne);
					mList.set(j+1, temp);
				}
			}
		}
	}
	
	/**
	 * 선택정렬로 곡 오름차순 연습
	 */
	public void selectionSortByTitleASC() {
		int min;
		for(int i = 0; i < mList.size(); i++) {
			min = i;
			for(int j = i+1; j < mList.size(); j++) {
				Music mOne = mList.get(min);
				Music mTwo = mList.get(i);
				if(mOne.getTitle().compareTo(mTwo.getTitle()) > 0) {
//					Music temp 
				}
			}
		}
	}
	
	/**
	 * 버블정렬로 곡 명 오름차순 정렬
	 */
	public void bubblwSortByTitleASC() {
//		int [] nums; -> mList로 변경 필요
		for(int i = 0; i < mList.size(); i++) {
			for(int j = 0; j < (mList.size()-1)-i; j++) {
				Music mOne = mList.get(j);
				Music mTwo = mList.get(j+1);
				// The operator > is undefined for the argument type(s) 
				// java.lang.String, java.lang.String
				// => String 과 String은 꺽쇠로 비교할 수 없음
				// String이 가지고있는 compareTo() 메소드 이용
				// 결과값이 0이면 동일함
				// 결과값이 양수값(+)이면 왼쪽이 순서가 더 큼
				// 결과값이 음수값(-)이면 왼쪽이 순서가 작음
				if(mOne.getTitle().compareTo(mTwo.getTitle()) > 0) {
					Music temp = mOne;
					mList.set(j, mTwo);
					mList.set(j+1, temp);
				}
			}
		}
	}
	/**
	 * 곡명으로 내림차순 정렬 (버블 정렬)
	 */
	public void bubbleSortByTitleDESC() {
		for(int i = 0; i < mList.size(); i++) {
			for(int j = 0; j < (mList.size()-1)-i; j++) {
				Music mOne = mList.get(j);
				Music mTwo = mList.get(j+1);
				if(mOne.getTitle().compareTo(mTwo.getTitle()) < 0) {
					Music temp = mOne;
					mList.set(j, mTwo);
					mList.set(j+1, temp);
				}
			}
		}
	}
	
	/**
	 * 가수명으로 오름차순 정렬(버블정렬)
	 */
	public void bubblwSortBySingerASC() {
//		int [] nums; -> mList로 변경 필요
		for(int i = 0; i < mList.size(); i++) {
			for(int j = 0; j < (mList.size()-1)-i; j++) {
				Music mOne = mList.get(j);
				Music mTwo = mList.get(j+1);
				if(mOne.getSinger().compareTo(mTwo.getSinger()) > 0) {
					Music temp = mOne;
					mList.set(j, mTwo);
					mList.set(j+1, temp);
				}
			}
		}
	}
	/**
	 * 가수명으로 내림차순 정렬(버블정렬)
	 */
	public void bubbleSortBySingerDESC() {
		for(int i = 0; i < mList.size(); i++) {
			for(int j = 0; j < (mList.size()-1)-i; j++) {
				Music mOne = mList.get(j);
				Music mTwo = mList.get(j+1);
				if(mOne.getSinger().compareTo(mTwo.getSinger()) < 0) {
					Music temp = mOne;
					mList.set(j, mTwo);
					mList.set(j+1, temp);
				}
			}
		}
	}
	
	
	
	
}
