package gui;

import java.awt.*;

public class ClientForm extends Frame {

    private Button bStart;
    private Button bStop;
    private Button bExit;
    private Label lPort;
    private TextField tfPort;
    private Label lLog;
    private TextField tfLog;

    private CheckboxGroup cg;
    private Checkbox viewAll;
    private Checkbox viewPred;
    private Checkbox viewHerb;
    private Checkbox viewGrass;
    private TextArea tAview;

    private Label lCreate;
    private Label lType;
    private Label lName;
    private Label lMass;
    private Choice chType;
    private Button bTypeLoad;
    private TextField tfName;
    private TextField tfMass;
    private Button bCreate;

    private Label lEat;
    private Choice chEat;
    private Button bEatLoad;
    private Label lWhatEat;
    private Choice chWhatEat;
    private Button bEat;

    private Label lRemove;
    private Choice chRemove;
    private Choice chIdRemove;
    private Button bRemove;
    private Button bRemoveLoad;

    private Label lReact;
    private TextArea tAreact;

    public ClientForm() {

        this.setSize(600, 700);
        setLayout(new GridLayout(5, 1));

        Panel connectionPanel = new Panel(new FlowLayout(FlowLayout.LEFT, 30, 30));
        lPort = new Label("Порт:");
        connectionPanel.add(lPort);
        tfPort = new TextField("5050", 20);
        tfPort.setEnabled(true);
        connectionPanel.add(tfPort);
        bStart = new Button("Подключить");
        bStart.setEnabled(true);
        connectionPanel.add(bStart);
        bStop = new Button("Отключить");
        bStop.setEnabled(false);
        connectionPanel.add(bStop);
        bExit = new Button("Выход");
        bExit.setEnabled(true);
        connectionPanel.add(bExit);
        lLog = new Label("Информация:");
        connectionPanel.add(lLog);
        tfLog = new TextField(40);
        tfLog.setEnabled(false);
        connectionPanel.add(tfLog);
        this.add(connectionPanel);
        connectionPanel.setBackground(new Color(240, 240, 240));

        Panel viewPanel = new Panel(new FlowLayout(1, 10, 5));

        cg = new CheckboxGroup();

        viewAll = new Checkbox("Просмотр всех", cg, false);
        viewPanel.add(viewAll);
        viewPred = new Checkbox("Просмотр хищников", cg, false);
        viewPanel.add(viewPred);
        viewHerb = new Checkbox("Просмотр травоядных", cg, false);
        viewPanel.add(viewHerb);
        viewGrass = new Checkbox("Просмотр травы", cg, false);
        viewPanel.add(viewGrass);
        tAview = new TextArea(5, 60);
        viewPanel.add(tAview);

        this.add(viewPanel);
        viewPanel.setBackground(new Color(240, 240, 240));


        Panel createPanel = new Panel(new FlowLayout(1, 50, 20));
        lCreate = new Label("Создание:");
        createPanel.add(lCreate);

        lType = new Label("Тип животного");
        createPanel.add(lType);
        chType = new Choice();
        chType.setPreferredSize(new Dimension(150, 20));
        createPanel.add(chType);
        bTypeLoad = new Button("!");
        bTypeLoad.setEnabled(false);
        createPanel.add(bTypeLoad);


        lName = new Label("Имя");
        createPanel.add(lName);
        tfName = new TextField();
        tfName.setPreferredSize(new Dimension(100, 20));
        createPanel.add(tfName);
        lMass = new Label("Масса");
        createPanel.add(lMass);
        tfMass = new TextField();
        tfMass.setPreferredSize(new Dimension(100, 20));
        createPanel.add(tfMass);

        bCreate = new Button("Создать");
        createPanel.add(bCreate);

        this.add(createPanel);
        createPanel.setBackground(new Color(240, 240, 240));


        Panel eatPanel = new Panel(new FlowLayout(1, 10, 20));
        lEat = new Label("Кого:");
        eatPanel.add(lEat);
        chEat= new Choice();
        chEat.setPreferredSize(new Dimension(150, 20));
        eatPanel.add(chEat);
        bEatLoad = new Button("!");
        bEatLoad.setEnabled(false);
        eatPanel.add(bEatLoad);

        lWhatEat = new Label("Чем:");
        eatPanel.add(lWhatEat);
        chWhatEat= new Choice();
        chWhatEat.setPreferredSize(new Dimension(150, 20));
        eatPanel.add(chWhatEat);
        bEat = new Button("Покормить");
        eatPanel.add(bEat);


        lRemove = new Label("Кого:");
        eatPanel.add(lRemove);
        chRemove= new Choice();
        chRemove.setPreferredSize(new Dimension(150, 20));
        eatPanel.add(chRemove);

        bRemoveLoad = new Button("!");
        bRemoveLoad.setEnabled(false);
        eatPanel.add(bRemoveLoad);
        chIdRemove= new Choice();
        chIdRemove.setPreferredSize(new Dimension(150, 20));
        eatPanel.add(chIdRemove);
        bRemove = new Button("Удалить");
        eatPanel.add(bRemove);


        this.add(eatPanel);
        eatPanel.setBackground(new Color(240, 240, 240));

        Panel reactPanel = new Panel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        lReact = new Label("Реакция:");
        reactPanel.add(lReact);
        tAreact = new TextArea(5, 60);
        reactPanel.add(tAreact);
        this.add(reactPanel);
        reactPanel.setBackground(new Color(240, 240, 240));

        viewAll.setEnabled(false);
        viewPred.setEnabled(false);
        viewHerb.setEnabled(false);
        viewGrass.setEnabled(false);
        tAview.setEnabled(false);
        chType.setEnabled(false);
        tfName.setEnabled(false);
        tfMass.setEnabled(false);
        bCreate.setEnabled(false);
        chEat.setEnabled(false);
        chWhatEat.setEnabled(false);
        bEat.setEnabled(false);
        chRemove.setEnabled(false);
        chIdRemove.setEnabled(false);
        bRemoveLoad.setEnabled(false);
        bRemove.setEnabled(false);
        tAreact.setEnabled(false);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void connectServer(){

        bStart.setEnabled(false);
        bStop.setEnabled(true);
        bExit.setEnabled(false);
        tfPort.setEnabled(false);
        tfLog.setText("");
        viewAll.setEnabled(true);
        viewPred.setEnabled(true);
        viewHerb.setEnabled(true);
        viewGrass.setEnabled(true);
        tAview.setEnabled(true);
        chType.setEnabled(true);
        bTypeLoad.setEnabled(true);
        tfName.setEnabled(true);
        tfMass.setEnabled(true);
        bCreate.setEnabled(true);
        chRemove.setEnabled(true);
        bRemoveLoad.setEnabled(true);
        bRemove.setEnabled(true);
        chEat.setEnabled(true);
        chWhatEat.setEnabled(true);
        chIdRemove.setEnabled(true);
        bEat.setEnabled(true);
        bEatLoad.setEnabled(true);
        tAreact.setEnabled(true);
    }

    public void disconnectClient(){
        bStart.setEnabled(true);
        bStop.setEnabled(false);
        bExit.setEnabled(true);
        tfPort.setEnabled(true);
        tfLog.setText("");
        viewAll.setEnabled(false);
        viewPred.setEnabled(false);
        viewHerb.setEnabled(false);
        viewGrass.setEnabled(false);
        tAview.setEnabled(false);
        cg.setSelectedCheckbox(null);
        chType.setEnabled(false);
        bTypeLoad.setEnabled(false);
        tfName.setEnabled(false);
        tfMass.setEnabled(false);
        bCreate.setEnabled(false);
        chRemove.setEnabled(false);
        chIdRemove.setEnabled(false);
        bRemoveLoad.setEnabled(false);
        bRemove.setEnabled(false);
        chEat.setEnabled(false);
        chWhatEat.setEnabled(false);
        bEat.setEnabled(false);
        bEatLoad.setEnabled(false);
        tAreact.setEnabled(false);
    }

    public void putAllEaters(String data){
        chEat.addItem(data);
    }

    public void putAllAnimals(String data){
        tAview.setText(data);
    }

    public void putAllTypes(String data){
        chType.addItem(data);
    }

    public void exitClient() {
        this.dispose();
    }

    public Button getbCreate() {
        return bCreate;
    }

    public void setbCreate(Button bCreate) {
        this.bCreate = bCreate;
    }

    public TextField getTfPort() {
        return tfPort;
    }

    public void setTfPort(TextField tfPort) {
        this.tfPort = tfPort;
    }

    public Button getbStart() {
        return bStart;
    }

    public void setbStart(Button bStart) {
        this.bStart = bStart;
    }

    public Button getbExit() {
        return bExit;
    }

    public void setbExit(Button bExit) {
        this.bExit = bExit;
    }

    public Button getbStop() {
        return bStop;
    }

    public void setbStop(Button bStop) {
        this.bStop = bStop;
    }

    public TextField getTfLog() {
        return tfLog;
    }

    public void setTfLog(TextField tfLog) {
        this.tfLog = tfLog;
    }

    public TextArea gettAview() {
        return tAview;
    }

    public void settAview(TextArea tAview) {
        this.tAview = tAview;
    }

    public Checkbox getViewAll() {
        return viewAll;
    }

    public void setViewAll(Checkbox viewAll) {
        this.viewAll = viewAll;
    }

    public Checkbox getViewPred() {
        return viewPred;
    }

    public void setViewPred(Checkbox viewPred) {
        this.viewPred = viewPred;
    }

    public Checkbox getViewHerb() {
        return viewHerb;
    }

    public void setViewHerb(Checkbox viewHerb) {
        this.viewHerb = viewHerb;
    }

    public Checkbox getViewGrass() {
        return viewGrass;
    }

    public void setViewGrass(Checkbox viewGrass) {
        this.viewGrass = viewGrass;
    }

    public Choice getChType() {
        return chType;
    }

    public void setChType(Choice chType) {
        this.chType = chType;
    }

    public Choice getChEat() {
        return chEat;
    }

    public void setChEat(Choice chEat) {
        this.chEat = chEat;
    }

    public Button getbEatLoad() {
        return bEatLoad;
    }

    public void setbEatLoad(Button bEatLoad) {
        this.bEatLoad = bEatLoad;
    }

    public Button getbTypeLoad() {
        return bTypeLoad;
    }

    public void setbTypeLoad(Button bTypeLoad) {
        this.bTypeLoad = bTypeLoad;
    }

    public CheckboxGroup getCg() {
        return cg;
    }

    public void setCg(CheckboxGroup cg) {
        this.cg = cg;
    }

    public void setChecked(){
        cg.setSelectedCheckbox(null);
    }

    public TextField getTfName() {
        return tfName;
    }

    public void setTfName(TextField tfName) {
        this.tfName = tfName;
    }

    public TextField getTfMass() {
        return tfMass;
    }

    public void setTfMass(TextField tfMass) {
        this.tfMass = tfMass;
    }

    public TextArea gettAreact() {
        return tAreact;
    }

    public void settAreact(TextArea tAreact) {
        this.tAreact = tAreact;
    }

    public void putReact(String data){
        this.tAreact.setText(data);
    }

    public Button getbRemove() {
        return bRemove;
    }

    public void setbRemove(Button bRemove) {
        this.bRemove = bRemove;
    }

    public Button getbRemoveLoad() {
        return bRemoveLoad;
    }

    public void setbRemoveLoad(Button bRemoveLoad) {
        this.bRemoveLoad = bRemoveLoad;
    }

    public Choice getChRemove() {
        return chRemove;
    }

    public void setChRemove(Choice chRemove) {
        this.chRemove = chRemove;
    }

    public Choice getChIdRemove() {
        return chIdRemove;
    }

    public void setChIdRemove(Choice chIdRemove) {
        this.chIdRemove = chIdRemove;
    }

    public Choice getChWhatEat() {
        return chWhatEat;
    }

    public void setChWhatEat(Choice chWhatEat) {
        this.chWhatEat = chWhatEat;
    }

    public Button getbEat() {
        return bEat;
    }

    public void setbEat(Button bEat) {
        this.bEat = bEat;
    }
}


