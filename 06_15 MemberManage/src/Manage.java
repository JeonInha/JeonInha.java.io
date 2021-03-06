import java.util.*;

class Manage {
	Scanner sc = new Scanner(System.in);
	ClubMember[] club = new ClubMember[10];
	int clubMemberNum;

	/////////////////////////////////////////////
	/* 범용 메소드 */
	/////////////////////////////////////////////

	public Manage() { // 생성자: 작동부
		manage();
	}

	private void arrayNullRight() { // 삽입정렬 이용, Null을 오른쪽으로 밀어버리는 로직 / 등록, 삭제 등 club배열에 변동이 있을 때 이용
		for (int i = 0; i < club.length; i++) {
			for (int j = 0; j < club.length - 1; j++) {
				if (club[j] == null) {
					ClubMember x = club[j];
					club[j] = club[j + 1];
					club[j + 1] = x;
				}
			}
		}
	}

	private Human inputHuman() { // 사람 정보 입력받기
		System.out.print("신상정보를 입력하세요. 이름 / 키(cm) / 몸무게(kg):  ");
		String inputName = sc.next();
		double inputTall = sc.nextDouble();
		double inputWeight = sc.nextDouble();
		return new Human(inputName, inputTall, inputWeight);
	}

	/////////////////////////////////////////////
	/* 1. 정렬 출력 */
	/////////////////////////////////////////////

	private ClubMember[] returnNoNull() { // 정렬을 위해 Null이 없는 가변 배열 출력
		arrayNullRight();
		ClubMember[] copy = Arrays.copyOf(club, clubMemberNum);
		return copy;
	}

	private ClubMember[] chooseCriterion() { // 정렬 기준 고르기
		System.out.print("기준 선택    1. BMI 순(내림차순) / 2. 키(오름차순) / 3. 몸무게(오름차순) / 4. 이름 순(오름차순):  ");
		int input = sc.nextInt();
		ClubMember[] array = returnNoNull();
		if (input == 1) {
			Arrays.sort(array, new JudgeBMI_R());
		} else if (input == 2) {
			Arrays.sort(array, new JudgeTall());
		} else if (input == 3) {
			Arrays.sort(array, new JudgeWeight());
		} else if (input==4){
			Arrays.sort(array, new JudgeName());
		} else {
			System.out.println("잘못된 입력. 정렬 없이 출력합니다.");
		}
		return array;
	}

	private void printAllMembers(ClubMember[] a) { // 멤버 출력
		System.out.printf("[회원 수: %d]\n", clubMemberNum);
		System.out.println("-----------------------------------------------");
		System.out.println(" 이름\t | 키\t\t몸무게\tBMI\t상태");
		System.out.println("-----------------------------------------------");
		for (ClubMember member : a) {
			System.out.println(member);
		}
		System.out.println("-----------------------------------------------");
		System.out.println("출력 완료");
	}

	/////////////////////////////////////////////
	/* 2. 회원 등록 */
	/////////////////////////////////////////////

	private void registMember(Human input) {
		arrayNullRight();
		if (clubMemberNum != 10) {
			for (ClubMember member : club) { // 중복 판별
				if (input.equals(member)) {
					System.out.println("중복 등록은 불가합니다.");
					break;
				}
			}
			// null을 오른쪽으로 밀었기 때문에 clubMemberNum 인덱스의 배열은 멤버정보가 없는 첫배열::
			club[clubMemberNum] = new ClubMember(input.getName(), input.getTall(), input.getWeight());
			clubMemberNum++;

		} else {
			System.out.println("정원이 다 찼습니다. 등록이 불가합니다.");
		}
	}

	/////////////////////////////////////////////
	/* 3. 회원 정보 수정 */
	/////////////////////////////////////////////

	private void editMember() {
		int count = 0;
		System.out.println("수정할 회원의 정보 입력");
		Human input = inputHuman();
		for (int i = 0; i < club.length; i++) {
			if (input.equals(club[i])) {
				club[i] = null;
				System.out.println("회원의 수정 정보 입력");
				Human edit = inputHuman();
				club[i] = new ClubMember(edit.getName(), edit.getTall(), edit.getWeight());
				count++;
			}
		}
		if (count == 0) {
			System.out.println("미등록 회원 혹은 잘못된 입력입니다.");
			return;
		}
	}

	/////////////////////////////////////////////
	/* 4. 회원 삭제 */
	/////////////////////////////////////////////

	private void deleteMember() {
		int count = 0;
		System.out.print("지울 회원의 정보 입력");
		Human delete = inputHuman();
		for (int i = 0; i < club.length; i++) {
			if (delete.equals(club[i])) {
				System.out.printf("%s 회원의 정보를 삭제합니다.\n", club[i].getName());
				club[i] = null;
				clubMemberNum--;
				count++;
			}
		}
		if (count == 0)
			System.out.println("등록되지 않은 회원입니다.");
		arrayNullRight();
	}

	/////////////////////////////////////////////
	/* 동작 메소드 */
	/////////////////////////////////////////////

	private void manage() {
		club[0] = new ClubMember("Abert", 182, 77);
		club[1] = new ClubMember("Mike", 155, 42);
		club[2] = new ClubMember("Clair", 165, 55);
		club[3] = new ClubMember("Mclain", 171, 60);
		club[4] = new ClubMember("Luna", 186, 80);
		club[5] = new ClubMember("Tomy", 166, 60);
		club[6] = new ClubMember("Losa", 145, 55);
		club[7] = new ClubMember("Jina", 178, 66);
		int num = 0;
		clubMemberNum = 8;

		while (true) {
			System.out.println("====================");
			System.out.println("1. 회원 정보 열람");
			System.out.println("2. 회원 신규 등록");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 삭제");
			System.out.println();
			System.out.println("9. 프로그램 종료");
			System.out.println("--------------------");
			System.out.print("입력: ");
			num = sc.nextInt();
			System.out.println("====================");

			if (num == 1) {
				System.out.println("회원 정보 열람");
				printAllMembers(chooseCriterion());
			} else if (num == 2) {
				System.out.println("회원 신규 등록");
				registMember(inputHuman());
			} else if (num == 3) {
				System.out.println("회원 정보 수정");
				editMember();
			} else if (num == 4) {
				System.out.println("회원 삭제");
				deleteMember();
			} else if (num == 9) {
				System.out.println("프로그램을 종료합니다.");
				return;
			} else {
				System.out.println("잘못된 입력");
			}
		}
	}
}
