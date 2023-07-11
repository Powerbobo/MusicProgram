package com.kh.musicprogram.view;

import java.util.List;
import java.util.Scanner;

import com.kh.musicprogram.model.vo.Music;


// 입력받는 클래스이기 때문에 List 선언하지 않음!
public class MusicView {
	public int musicMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== === 메인 메뉴 === ===");
		System.out.println("1. 마지막 위치에 곡 추가");
		System.out.println("2. 첫 위치에 곡 추가");
		System.out.println("3. 전체 곡 목록 출력");
		System.out.println("4. 특정 곡 검색");
		System.out.println("5. 특정 곡 삭제");
		System.out.println("6. 특정 곡 정보수정");
		System.out.println("7. 곡명 오름차순 정렬");
		System.out.println("8. 곡명 내림차순 정렬");
		System.out.println("9. 가수명 오름차순 정렬");
		System.out.println("10. 가수명 내림차순 정렬");
		System.out.println("0. 종료");
		System.out.print("메뉴 선택 >> ");
		int choice = sc.nextInt();
		return choice;
	}
	// 마지막 위치에 곡 추가
	// Music 의 데이터를 리턴하는 메소드
	public Music inputMusicInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.print("곡명 : ");
		String title = sc.nextLine();
		System.out.print("가수명 : ");
		String singer = sc.nextLine();
		// 입력한 값 music 변수에 저장!
		Music music = new Music(title, singer);
		return music;
	}
	// 곡 검색
	// return 반환형 이용하기 때문에 반환형의 데이터 타입인 String 사용
	public String inputMusicName(String category) {
		Scanner sc = new Scanner(System.in);
		System.out.print(category + "할 곡 입력 : ");
		String title = sc.nextLine();
		// 입력한 값 title 변수에 저장!
		return title;
	}
	// 곡 수정하기
	public Music modifyMusicInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.print("곡명 : ");
		String title = sc.nextLine();
		System.out.print("가수명 : ");
		String singer = sc.nextLine();
		// 입력한 값 music 변수에 저장!
		Music music = new Music(title, singer);
		return music;
	}
	// Run 클래스에서 해당 메소드를 받아서 사용할 때, msg에 들어갈
	// 문자열을 () 안에 입력하면, 입력한 문자열이 출력됨.
	// 서비스 성공 메세지 메소드
	public void displaySuccess(String msg) {
		System.out.println("[서비스 성공] " + msg);
	}
	// 서비스 실패 메세지 메소드
	public void displayError(String msg) {
		System.out.println("[서비스 실패] " + msg);
	}
	
	public void printMessage(String message) {
		System.out.println(message);
	}
	
	
	// 전체 곡 목록 출력
	public void showAllMusicList(List<Music> allList) {
		int count = 1;
		System.out.println("========== 전체 곡 목록 출력 ==========");
		for(Music music : allList) {
			System.out.printf("%d번째 노래 -> 곡명 : %s, 가수명 : %s\n"
					, count++
					, music.getTitle()
					, music.getSinger());
		}
	}

}
