package com.kh.musicprogram.run;

import java.util.List;
import java.util.Scanner;

import com.kh.musicprogram.controller.MusicController;
import com.kh.musicprogram.model.vo.Music;
import com.kh.musicprogram.view.MusicView;



public class Run {
	public static void main(String[] args) {
		// MusicView 클래스 이용하기 위해서 객체 생성
		MusicView view = new MusicView();
		
		// MusicController 클래스를 이용하기 위해서 객체 생성
		MusicController mController = new MusicController();
		
		// Music 타입을 받기 위해서 music 변수 선언 -> 변수명은 임의로 생성한 것.
		// music 에 입력메소드를 넣어서 사용..!
		Music music = null;
		String title = "";
		int index = 0;
		
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			choice = view.musicMenu();
			switch(choice) {
				case 1 : 
					// MusicFunction -> MusicView, MusicController
					music = view.inputMusicInfo(); // 입력 메소드
					mController.addAtLast(music); // 입력한 값 출력하는 메소드
					view.displaySuccess("마지막 위치에 곡 추가 성공"); // 성공여부 출력 메세지
					break;
				case 2 : 
					music = view.inputMusicInfo();
					mController.addAtZero(music);
					view.displaySuccess("첫 위치에 곡 추가 성공");
					break;
				case 3 : 
					// List 로 받아서 사용
					List<Music> allList = mController.printMusicList();
					view.showAllMusicList(allList);
					view.displaySuccess("전체 정보 조회 성공!");
					break;
				case 4 : 
					title = view.inputMusicName("검색");
					List<Music> searchList = mController.searchMusicByName(title);
					view.showAllMusicList(searchList);
					view.displaySuccess("검색한" + title + "조회 성공!");
					break;
				case 5 : 
					title = view.inputMusicName("삭제");
					index = mController.searchOneByTitle(title);
					if(index == -1) {
						view.displayError("존재하지 않습니다.");
						break;
					}
					mController.removeMusic(index);
					view.displaySuccess("곡 삭제 성공!");
					break;
				case 6 : 
					// 수정할 곡 입력 받기
					title = view.inputMusicName("수정");
					// 존재여부 확인
					index = mController.searchOneByTitle(title);
					if(index == -1) {
						view.displayError("존재하지 않습니다.");
						break;
					}
					// 이후 수정하기
					// 수정할 정보 입력받기
					music = view.modifyMusicInfo();
					// 수정하기
					mController.updateMusic(index, music);
					break;
				case 7 : 
					view.printMessage("=============== 곡명 오름차순 정렬 ===============");
					// 버블 정렬
					mController.bubblwSortByTitleASC();
					// 삽입 정렬
					mController.insertionSortByTitleASC();
					// 선택 정렬
					mController.selectionSortByTitleASC();
					
					view.displaySuccess("정렬 성공! 3번을 눌러 출력해주세요!");
					break;
				case 8 : 
					view.printMessage("=============== 곡명 내림차순 정렬 ===============");
					mController.bubbleSortByTitleDESC();
					view.displaySuccess("정렬 성공! 3번을 눌려 출력해주세요!");
					break;
				case 9 : 
					view.printMessage("=============== 가수명 오름차순 정렬 ===============");
					mController.bubblwSortBySingerASC();
					view.displaySuccess("정렬 성공! 3번을 눌려 출력해주세요!");
					break;
				case 10 : 
					view.printMessage("=============== 가수명 내림차순 정렬 ===============");
					mController.bubbleSortBySingerDESC();
					view.displaySuccess("정렬 성공! 3번을 눌려 출력해주세요!");
					break;
				case 0 : 
					view.printMessage("프로그램을 종료했습니다.");
					break;
				default : 
					view.printMessage("잘못 입력하셨습니다.");
					break;
			}
		} while(choice != 0); // 조건문 -> 해당 조건이 발생하기 전까지 무한반복
	}
}
